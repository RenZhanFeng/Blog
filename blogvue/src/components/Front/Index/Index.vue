<template>
  <el-row class="index">
    <el-container>
      <el-col :xs="0" :sm="0" :md="0" :lg="0" :xl="2"></el-col>
      <el-col class="userInof card" :xs="0" :sm="7" :md="8" :lg="6">
        <el-row>
          <el-col :span="24" class="item">qwe</el-col>
        </el-row>
      </el-col>
      <el-col class="blogList card" :xs="24" :sm="17" :md="16" :lg="13">
        <el-row>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
        </el-row>
      </el-col>
      <el-col class="blogCategory card" :xs="0" :sm="0" :md="0" :lg="5">
        <el-row>
          <el-col :span="24" class="item">qwe</el-col>
          <el-col :span="24" class="item">qwe</el-col>
        </el-row>
      </el-col>
      <el-col :xs="0" :sm="0" :md="0" :lg="0" :xl="2"></el-col>
    </el-container>
  </el-row>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {};
  }
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.index {
  margin-top: 40px;
}

.card {
  margin-left: 10px;
  margin-right: 10px;
}

.item {
  margin-bottom: 20px;
  padding: 20px;
  Shadow();
}
</style>
