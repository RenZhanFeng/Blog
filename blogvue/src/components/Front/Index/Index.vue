<template>
  <div class="index">
    <el-row class="indexMain" :gutter="gutter">
      <el-col class="userInof" :xs="24" :sm="6" :md="6" :lg="{span:4,push:3}">
        <user-info></user-info>
      </el-col>
      <el-col class="blogList" :xs="24" :sm="18" :md="18" :lg="{span:9,push:3}">
        <router-view></router-view>
        <blog-list v-show="this.$router.currentRoute.path === '/index'" ref="blogList"></blog-list>
      </el-col>
      <el-col class="blogCategory hidden-md-and-down" :lg="{span:3,push:3}">
        <category @categoryCid="categoryData"></category>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import "element-ui/lib/theme-chalk/display.css";
import BlogList from "Fcomponents/Index/common/blogList";
import UserInfo from "Fcomponents/Index/common/userInfo";
import Category from "Fcomponents/Index/common/category";
export default {
  name: "Index",
  components: {
    BlogList,
    UserInfo,
    Category
  },
  data() {
    return {
      gutter: null
    };
  },
  created() {
    window.addEventListener("resize", this.getGutter);
    this.getGutter();
  },
  watch: {
    $route() {
      if (this.$route.path === "/index" && this.$route.query.cid) {
        this.$refs.blogList.articles =''
        this.categoryData(this.$route.query.cid);
      }
    }
  },
  methods: {
    getGutter() {
      return (this.gutter = window.innerWidth < 768 ? 0 : 20);
    },
    //点击分类会加载对应的分类数据
    categoryData(cid) {
      let url = cid == 16 ? `/articles`:`/articles/cid=${cid}`
      if (cid === 0) {
        this.$refs.blogList.loadArticles();
        this.$router.push({ path: "/index" });
      } else {
        this.$axios.get(url).then(resolve => {
          if (resolve.data.code === 200) {
            this.$refs.blogList.articles = resolve.data.data.content;
            this.$refs.blogList.total = resolve.data.data.totalElements;
            this.$router.push({ path: "/index" });
          }
        });
      }
    }
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.index {
  background: #f6f6f6;
  padding: 40px 0;
}

.indexMain {
  margin: 0 10px !important;
}

.item {
  margin-bottom: 20px;
  padding: 20px;
  Shadow();
}
</style>