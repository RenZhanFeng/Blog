<template>
  <div class="Books">
    <search-bar refs="searchBar" @onSearch="searchResult"></search-bar>
    <el-row :gutter="30">
      <el-col :xs="12" :sm="6" :md="6" :lg="6" v-for="(item,index) in booksPagination" :key="index">
        <el-tooltip effect="dark" placement="right" :open-delay="Number(300)">
          <p slot="content" class="tooltipBook">书名：{{item.title}}</p>
          <p slot="content" class="tooltipAut">作者：{{item.author}}</p>
          <p slot="content" class="tooltipAbs">简介：{{item.abs}}</p>
          <div class="bookItems">
            <div class="itemImg">
              <img class :src="item.cover" alt="封面缺失" />
            </div>
            <p class="itemTitle">{{item.title}}</p>
            <p class="itemAuthor">{{item.author}}</p>
          </div>
        </el-tooltip>
      </el-col>
      <edit-form v-if="booksPagination.length < pagesize" @onSubmit="loadBooks"></edit-form>
    </el-row>
    <div v-if="!books.length" v-html="noBook"></div>
    <el-row>
      <el-pagination
        class="pagination"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="books.length"
        @current-change="handleCurrentChange"
      ></el-pagination>
    </el-row>
  </div>
</template>

<script>
import SearchBar from "components/Library/common/SearchBar";
import EditForm from "components/Library/common/EditForm";
export default {
  name: "Books",
  data() {
    return {
      books: [],
      noBook: "很抱歉，暂时无相关书籍,可以添加",
      currentPage: 1,
      pagesize: 12
    };
  },
  components: {
    SearchBar,
    EditForm
  },
  mounted() {
    this.loadBooks();
  },
  computed: {
    //数据分页
    booksPagination() {
      return this.books.slice(
        (this.currentPage - 1) * this.pagesize,
        this.currentPage * this.pagesize
      );
    }
  },
  methods: {
    //打开页面的时候初始化获取图书信息
    loadBooks() {
      this.$axios
        .get("/books")
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.books = resolve.data.data;
          } else {
            console("获取数据失败");
          }
        })
        .catch(reject => {
          console.log(reject);
        });
    },
    //搜索框搜索功能
    searchResult(keywords) {
      this.$axios
        .get("/search", {
          params: { keywords: keywords }
        })
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.books = resolve.data.data;
          } else {
            this.books = [];
            //this.noBook = resolve.data.data;
          }
        })
        .catch(reject => {
          console.log(reject);
        });
    },
    //分页改变时触发
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.bookItems {
  margin-top: 10px;
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  cursor: pointer;
  Shadow();
}

.itemImg {
  position: relative;
  padding: 60% 20%;
  background: #f7f3f3;
}

.itemImg img {
  position: absolute;
  width: 100%;
  height: 100%;
  left: 0;
  top: 0;
  border-radius: 4px;
}

.itemTitle {
  font-size: 14px;
  color: #5f8bce;
  no-wrap();
}

.itemAuthor {
  color: #333;
  font-size: 13px;
  no-wrap();
}

.itemTitle, .itemAuthor {
  padding-top: 5px;
}

.pagination {
  text-align: center;
}

.tooltipBook {
  font-size: 14px;
  margin-bottom: 6px;
}

.tooltipAut {
  font-size: 12px;
  margin-bottom: 6px;
}

.tooltipAbs {
  width: 200px;
}
</style>
