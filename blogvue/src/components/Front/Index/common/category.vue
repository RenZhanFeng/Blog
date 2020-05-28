<template>
  <el-row :span="24" class="item">
    <el-menu class="categories" default-active="0">
      <!-- <el-menu-item class="menuItem" index="0" @click="handleSelect(0)">
        <template>全部</template>
      </el-menu-item> -->
      <el-menu-item
        class="menuItem"
        v-for="(item, index) in categories"
        :key="index"
        :index="String(item.sort)"
        @click="handleSelect(item.id)"
      >
        <template>{{item.name}}</template>
      </el-menu-item>
    </el-menu>
  </el-row>
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

<style scoped lang='stylus'>
@import '~stylus/mixin';
.item {
  margin-bottom: 20px;
  padding: 20px;
  Shadow();
}
.categories {
  border: 0;
}
.menuItem {
  text-align: center;
}
</style>