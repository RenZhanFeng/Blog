<template>
  <el-menu
    router
    :default-active="RoutingPpath"
    class="el-menu-demo"
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="#3273dc"
  >
    <el-menu-item v-for="(item, index) in navList" :key="index" :index="item.name">{{item.navItem}}</el-menu-item>
    <div>
      <a href="#more" class="more">
        <i class="el-icon-menu moreIcon"></i>更多功能
      </a>
    </div>
  </el-menu>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
      RoutingPpath: this.$route.path,
      navList: [
        { name: "/index", navItem: "博客首页" },
        { name: "/library", navItem: "图书馆" },
        { name: "/admin", navItem: "个人中心" }
      ]
    };
  }
};
</script>

<style scoped>
.more {
  color: #222;
  float: right;
  line-height: 60px;
  padding: 0 10px 0 5px;
}
.moreIcon {
  float: right;
  font-size: 20px;
  color: #222;
  line-height: 60px;
}
.el-menu-demo {
  box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.05);
}

@media screen and (max-width: 768px) {
  .more {
    display: none;
  }
  .el-icon-menu {
    float: left !important;
    margin-right: 10px;
  }
}
</style>
