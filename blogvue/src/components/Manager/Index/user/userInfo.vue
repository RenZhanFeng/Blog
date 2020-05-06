<template>
  <div>
    <el-row>
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/manager/index/blog'}">管理中心</el-breadcrumb-item>
        <el-breadcrumb-item>用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户信息</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
   
  </div>
</template>

<script>
export default {
  name: "userInfo"
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';
</style>
