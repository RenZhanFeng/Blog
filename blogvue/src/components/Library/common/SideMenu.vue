<template>
  <el-menu class="categories">
    <el-menu-item
      class="Item"
      v-for="(item, index) in navList"
      :key="index"
      :index="index.toString()"
    >
      <template>
        <i :class="item.icon"></i>
        {{item.title}}
      </template>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  data() {
    return {
      navList: [
        { title: "全部", icon: "el-icon-s-grid" },
        { title: "流行", icon: "el-icon-pear" },
        { title: "文化", icon: "el-icon-ice-cream-round" },
        { title: "生活", icon: "el-icon-cherry" },
        { title: "经管", icon: "el-icon-burger" },
        { title: "科技", icon: "el-icon-cold-drink" }
      ]
    };
  }
};
</script>

<style scoped>
.categories {
  border: 0;
}
.Item {
  text-align: center;
}
</style>