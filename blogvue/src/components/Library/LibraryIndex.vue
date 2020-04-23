<template>
  <el-row>
    <el-container>
      <el-col :xs="0" :sm="3" :md="3" :lg="5"></el-col>
      <el-col :xs="0" :sm="5" :md="3" :lg="2">
        <el-aside class="asideBar hidden-xs-only">
          <side-menu @categoryCid="categoryData"></side-menu>
        </el-aside>
      </el-col>
      <el-col :xs="24" :sm="19" :md="15" :lg="12">
        <el-main class="books-area">
          <books ref="booksArea"></books>
        </el-main>
      </el-col>
      <el-col :xs="0" :sm="3" :md="3" :lg="5"></el-col>
    </el-container>
  </el-row>
</template>
<script>
import SideMenu from "components/Library/common/SideMenu";
import Books from "components/Library/common/Books";
export default {
  name: "AppLibrary",
  components: {
    SideMenu,
    Books
  },
  methods: {
    categoryData(cid) {
      let url = `/categories/${cid}/books`;
      if (cid === 0) {
        this.$refs.booksArea.loadBooks();
      } else {
        this.$axios.get(url).then(resolve => {
          if (resolve.data.code === 200) {
            this.$refs.booksArea.books = resolve.data.data;
          }
        });
      }
    }
  }
};
</script>
<style scoped lang='stylus'>
@import '~stylus/mixin';

.asideBar {
  width: 100% !important;
}

.books-area {
  margin-left: 20px;
  margin-bottom: 30px;
}

.books-area, .asideBar {
  margin-top: 20px;
  Shadow();
}

@media screen and (max-width: 786px) {
  .books-area {
    margin-left: 0;
  }
}
</style>