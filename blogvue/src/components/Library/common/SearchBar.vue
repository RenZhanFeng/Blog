<template>
  <div class="searchMain">
    <el-input
      class="searchBar input-with-select"
      placeholder="请输入书名或作者"
      clearable
      size="small"
      v-model="keywords"
    >
      <el-button slot="append" icon="el-icon-search" @click="searchClick"></el-button>
    </el-input>
  </div>
</template>

<script>
export default {
  name: "SearchBar",
  data() {
    return {
      keywords: ""
    };
  },
  methods: {
    searchClick() {
      this.$emit("onSearch", this.keywords);
    }
  }
};
</script>

<style scoped>
.searchBar {
  width: 300px;
  margin: 10px 0 20px 0;
}
@media screen and (max-width: 786px) {
  .searchBar {
    width: 100%;
    margin-top: 0;
  }
}
</style>