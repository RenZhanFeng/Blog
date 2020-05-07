<template>
  <div class="index">
    <el-row class="indexMain" :gutter="gutter">
      <el-col class="userInof" :xs="24" :sm="6" :md="6" :lg="{span:4,push:3}">
        <user-info></user-info>
      </el-col>
      <el-col class="blogList" :xs="24" :sm="18" :md="18" :lg="{span:9,push:3}">
        <router-view></router-view>
        <blog-list v-show="this.$router.currentRoute.path === '/index'"></blog-list>
      </el-col>
      <el-col class="blogCategory hidden-md-and-down" :lg="{span:3,push:3}">
        <category></category>
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
  methods: {
    getGutter() {
      return (this.gutter = window.innerWidth < 768 ? 0 : 20);
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
