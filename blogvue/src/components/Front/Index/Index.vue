<template>
  <el-row class="index">
    <el-container>
      <el-col class="userInof" :xs="0" :sm="3" :md="3" :lg="3" style="background:#ccc"></el-col>
      <el-col class="userInof" :xs="0" :sm="4" :md="4" :lg="4" style="background:#000">1</el-col>
      <el-col class="blogList" :xs="0" :sm="10" :md="10" :lg="10" style="background:#fff">2</el-col>
      <el-col class="blogCategory" :xs="0" :sm="4" :md="4" :lg="4" style="background:#000">3</el-col>
      <el-col class="userInof" :xs="0" :sm="3" :md="3" :lg="3" style="background:#ccc"></el-col>
    </el-container>
  </el-row>
</template>

<script>
export default {
  name: "Index"
};
</script>

<style scoped>
.idnex {
  padding: 20px;
}
</style>
