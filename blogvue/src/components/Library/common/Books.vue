<template>
  <div class="Books">
    <el-row :gutter="30">
      <el-col :xs="12" :sm="6" :md="6" :lg="6" v-for="(item,index) in books" :key="index">
        <el-tooltip effect="dark" placement="right" :open-delay="Number(300)">
          <p slot="content" class="tooltipBook">书名：{{item.title}}</p>
          <p slot="content" class="tooltipAut">作者：{{item.author}}</p>
          <p slot="content" class="tooltipAbs">简介：{{item.abs}}</p>
          <div class="bookItems">
            <img class="itemImg" :src="item.cover" alt="img" />
            <p class="itemTitle">{{item.title}}</p>
            <p class="itemAuthor">{{item.author}}</p>
          </div>
        </el-tooltip>
      </el-col>
    </el-row>
    <el-row>
      <el-pagination class="pagination" :current-page="1" :page-size="10" :total="books.length"></el-pagination>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Books",
  data() {
    return {
      books: []
    };
  },
  mounted() {
    this.loadBooks();
  },
  methods: {
    //获取图书信息
    loadBooks() {
      this.$axios
        .get("/books")
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.books = resolve.data.books;
          } else {
            console("获取数据失败");
          }
        })
        .catch(reject => {
          console.log(reject);
        });
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
  width: 100%;
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
