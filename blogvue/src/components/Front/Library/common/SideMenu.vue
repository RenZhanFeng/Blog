<template>
  <el-menu class="categories" default-active="0">
    <el-menu-item class="Item" index="0" @click="handleSelect(0)">
      <template>
        <i class="el-icon-s-grid"></i>
        全部
      </template>
    </el-menu-item>
    <el-menu-item
      class="Item"
      v-for="(item, index) in categories"
      :key="index"
      :index="String(item.id)"
      @click="handleSelect(item.id)"
    >
      <template>
        <i class="el-icon-ship"></i>
        {{item.name}}
      </template>
    </el-menu-item>
  </el-menu>
</template>

<script>
import { mapState } from "vuex";
export default {
  mounted() {
    this.getCategoryList();
  },
  computed: {
    ...mapState(["categories"])
  },
  methods: {
    handleSelect(cid) {
      this.$emit("categoryCid", cid);
    },
    //获取分类数据
    getCategoryList() {
      this.$axios.get("/categories").then(resolve => {
        if (resolve.data.code === 200) {
          this.$store.state.categories = resolve.data.data;
        }
      });
    }
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