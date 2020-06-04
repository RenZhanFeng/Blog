<template>
  <div class="front">
    <nav-menu></nav-menu>
    <router-view />
    <el-button class="backTop" type="primary" @click="backTop" v-show="btnFlag">
      <i class="el-icon-arrow-up"></i>
    </el-button>
    <back-top></back-top>
    <el-row class="footer">
      <a href="http://www.beian.miit.gov.cn">粤ICP备20046473号</a>
    </el-row>
  </div>
</template>

<script>
import NavMenu from "Fcomponents/NavBar/NavMenu";
import BackTop from "Fcomponents/common/backTop";
export default {
  name: "Front",
  components: {
    NavMenu,
    BackTop
  },
  data() {
    return {
      btnFlag: false,
      scrollTop: null
    };
  },
  mounted() {
    window.addEventListener("scroll", this.scrollToTop);
  },
  methods: {
    //返回顶部
    backTop() {
      let timer = setInterval(() => {
        console.log(-this.scrollTop / 5);
        let ispeed = Math.floor(-this.scrollTop / 5);
        document.documentElement.scrollTop = document.body.scrollTop =
          this.scrollTop + ispeed;
        if (this.scrollTop === 0) {
          clearInterval(timer);
        }
      }, 16);
    },
    //计算滚动条的位置，以此控制返回顶部按钮的显示和隐藏
    scrollToTop() {
      let scrollTop =
        window.pageYOffset ||
        document.documentElement.scrollTop ||
        document.body.scrollTop;
      this.scrollTop = scrollTop;
      this.scrollTop > 60 ? (this.btnFlag = true) : (this.btnFlag = false);
    }
  }
};
</script>

<style scoped lang='stylus'>
.footer {
  width: 100%;
  height: 20vh;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
  border-top: solid 1px #e6e6e6;
  padding: 20px;
  text-align: center;
}

.backTop {
  position: fixed;
  bottom: 22%;
  right: 25%;
  background: #fff;
  color: #000;
  border: 0;
  font-size: 20px;
  font-weight: 700 !important;
  text-align: center;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
}

@media screen and (max-width: 1200px) {
  .backTop {
    position: fixed;
    bottom: 22%;
    right: 1%;
  }
}
</style>