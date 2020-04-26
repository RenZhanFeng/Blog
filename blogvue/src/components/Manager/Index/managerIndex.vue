<template>
  <el-container style="height: 100vh;">
    <side-bar ref="sideBar"></side-bar>
    <el-container class="aaa">
      <el-header class="header">
        <i class="el-icon-s-fold" @click="fold" ref="fold"></i>
        <i class="logout el-icon-switch-button" v-on:click="logout"></i>
      </el-header>
      <el-main>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import SideBar from "Mcomponents/Index/sideBar/sideBar";
export default {
  data() {
    return {};
  },
  components: {
    SideBar
  },
  methods: {
    //退出登录
    logout() {
      window.localStorage.removeItem("user");
      this.$router.replace("/manager/login");
    },
    //折叠或展开侧边栏
    fold() {
      let isCollapse = this.$refs.sideBar.isCollapse;
      this.$refs.sideBar.isCollapse = !isCollapse;
      if (isCollapse == false) {
        this.$refs.fold.className = "el-icon-s-unfold";
      } else {
        this.$refs.fold.className = "el-icon-s-fold";
      }
    }
  }
};
</script>

<style scoped lang="stylus">
@import '~stylus/variable';

.header {
  height: 50px !important;
  background-color: #009688;
  box-shadow: 0 2px 5px #bbc7c4;
}

.logout {
  font-size: 30px;
  line-height: 50px;
  float: right;
  color: #ccc;
  cursor: pointer;
}

.el-icon-s-unfold, .el-icon-s-fold {
  font-size: 23px;
  line-height: 50px;
  color: #fff;
  cursor: pointer;
}
</style>