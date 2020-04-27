<template>
  <div class="sidBar">
    <el-menu class="elmenu" default-active="/blog" :collapse="isCollapse" active-text-color="#009688">
      <div class="sidebarLogo">
        <img class="logo" src="~assets/logo.png" alt="logo" />
        <h1 v-show="!isCollapse">博客后台</h1>
      </div>
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-user"></i>
          <span slot="title">用户管理</span>
        </template>
        <el-menu-item index="1-1">用户信息</el-menu-item>
        <el-menu-item index="1-2">角色配置</el-menu-item>
      </el-submenu>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-document"></i>
          <span slot="title">内容管理</span>
        </template>
        <el-menu-item index="/blog">博客内容管理</el-menu-item>
        <el-menu-item index="2-2">图书内容管理</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "sideBar",
  data() {
    return {
      isCollapse: false
    };
  },
  methods: {
    shift() {
      this.isCollapse = !this.isCollapse;
      console.log(this.isCollapse);
    }
  }
};
</script>

<style scoped>
.sidBar {
  background: #fff;
}
.elmenu {
  border: 0 !important;
}
.sidebarLogo {
  display: flex;
  align-items: center;
  height: 50px;
  background: #009688;
  box-sizing: border-box;
  padding: 5px 20px;
}
.sidebarLogo h1 {
  margin-left: 10px;
}
.sidebarLogo img {
  width: 35px;
}
</style>