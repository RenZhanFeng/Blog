<template>
  <div class="Books">
    <search-bar refs="searchBar" @onSearch="searchResult"></search-bar>
    <edit-form @onSubmit="loadBooks" ref="editForm"></edit-form>
    <el-row :gutter="30">
      <el-col :xs="12" :sm="6" :md="6" :lg="6" v-for="(item,index) in booksPagination" :key="index">
        <el-tooltip effect="dark" placement="right" :open-delay="Number(300)">
          <p slot="content" class="tooltipBook">书名：{{item.title}}</p>
          <p slot="content" class="tooltipAut">作者：{{item.author}}</p>
          <p slot="content" class="tooltipAbs">简介：{{item.abs}}</p>
          <div class="bookItems">
            <div class="itemImg" @click="setBook(item)">
              <img class :src="item.cover" alt="封面缺失" />
            </div>
            <div class="itemTitleWrap">
              <p class="itemTitle" v-if="item.title">{{item.title}}</p>
            </div>
            <div class="itemAuthorWrap">
              <p class="itemAuthor" v-if="item.author">{{item.author}}</p>
            </div>
            <i class="el-icon-delete" @click="deleteBook(item.id,item.title)"></i>
          </div>
        </el-tooltip>
      </el-col>
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
import SearchBar from "Fcomponents/Library/common/SearchBar";
import EditForm from "Fcomponents/Library/common/EditForm";
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
            console.log("获取数据失败");
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
    },
    //删除图书
    deleteBook(id, title) {
      this.$confirm("此操作将用久删除该书籍, 是否继续?", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$axios
            .post("/delete", { id: id, title: title })
            .then(resolve => {
              if (resolve.data.code === 200) {
                this.loadBooks();
                this.$alert(resolve.data.data);
              }
            });
        })
        .catch(reject => console.log(reject));
    },
    //修改图书
    setBook(item) {
      this.$refs.editForm.dialogFormVisible = true;
      this.$refs.editForm.form = {
        id: item.id,
        cover: item.cover,
        title: item.title,
        author: item.author,
        date: item.date,
        press: item.press,
        abs: item.abs,
        category: {
          id: item.category.id.toString(),
          name: item.category.name
        }
      };
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.Books {
  position: relative;
}

.bookItems {
  position: relative;
  margin-top: 10px;
  margin-bottom: 10px;
  padding: 10px;
  border: 1px solid #ccc;
  cursor: pointer;
  Shadow();
}

.itemImg {
  holdParent(130%);
}

.itemImg img {
  holdChild();
  border-radius: 4px;
}

.itemTitleWrap, .itemAuthorWrap {
  display: flex;
  holdParent(13%);
  margin-top: 5px;
}

.itemTitleWrap p {
  holdChild();
}

.itemAuthorWrap p {
  holdChild();
  width: 88%;
}

.itemTitle {
  font-size: 14px;
  color: #5f8bce;
  no-wrap();
  background: #fff;
}

.itemAuthor {
  color: #333;
  font-size: 13px;
  no-wrap();
  background: #fff;
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

.el-icon-delete {
  position: absolute;
  right: 10px;
  bottom: 10px;
  background: #fff;
  padding: 8px 0 0 6px;
}
</style>
