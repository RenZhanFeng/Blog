<template>
  <el-row>
    <el-col class="item" :span="24">
      <div class="user-icon">
        <span>
          <img src="~assets/cover.png" alt="头像" />
        </span>
      </div>
      <div class="user-introduction">
        <div class="user-name">Roger</div>
        <div class="user-title">专注于前端开发</div>
      </div>
      <div class="user-statistics">
        <div>
          <h1 class="posts">原创</h1>
          <p>{{this.$store.state.postsTotal}}</p>
        </div>
        <div class="Browse">
          <h1>访问</h1>
          <p>999</p>
        </div>
        <div class="Like">
          <h1>获赞</h1>
          <p>999</p>
        </div>
      </div>
      <div class="user-contact">
        <el-divider content-position="center">社交账号</el-divider>
        <div class="contact-icon">
          <el-tooltip effect="dark" content="https://github.com/RenZhanFeng" placement="top-start">
            <i class="iconfont icon-github"></i>
          </el-tooltip>
          <el-tooltip effect="dark" content="微信号" placement="top">
            <i class="iconfont icon-shejiao-weixin"></i>
          </el-tooltip>
          <el-tooltip effect="dark" content="947625259" placement="top">
            <i class="iconfont icon-shejiao-QQ"></i>
          </el-tooltip>
          <el-tooltip effect="dark" content="947625259@qq.com" placement="top-end">
            <i class="iconfont icon-youxiang"></i>
          </el-tooltip>
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: "userInfo",
};
</script>

<style scoped lang='stylus'>
@import '~stylus/mixin';

.item {
  margin-bottom: 20px;
  padding: 20px;
  Shadow();
}

.item div {
  margin-bottom: 15px;
}

.user-icon span {
  display: block;
  width: 100px;
  height: 100px;
  margin: 0 auto;
  border-radius: 50%;
  overflow: hidden;
}

.user-icon span img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.user-introduction {
  text-align: center;
  color: #999;
}

.user-name {
  font-size: 20px;
  color: #1890ff;
}

.user-title {
  font-size: 14px;
}

.user-statistics {
  display: flex;
  justify-content: space-around;
  padding-top: 10px;
  color: #999;
  text-align center
}

.user-statistics div {
  line-height: 22px;
}

.user-statistics div p {
  font-size: 14px;
}

.contact-icon {
  padding-top: 10px;
  display: flex;
  justify-content: space-around;
}
</style>