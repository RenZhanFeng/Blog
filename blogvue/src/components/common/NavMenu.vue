<template>
  <el-menu
    :default-active="'/index'"
    class="el-menu-demo"
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="#3273dc"
  >
    <el-menu-item v-for="(item, index) in navList" :key="index" :index="item.name">{{item.navItem}}</el-menu-item>
    <div>
      <a href="#more" class="more">更多功能</a>
      <i class="el-icon-menu moreIcon"></i>
    </div>
  </el-menu>
</template>

<script>
export default {
  name: "NavMenu",
  data() {
    return {
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

@media screen and (max-width: 768px) {
  .more {
    display: none;
  }
  .moreIcon {
    margin-right: 10px;
  }
}
</style>
