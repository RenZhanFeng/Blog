<template>
  <div class="login" @keydown.enter="login">
    <el-form class="login-container">
      <h3 class="login_title">系统登录</h3>
      <el-form-item>
        <el-input type="text" v-model="loginForm.username" auto-complete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input type="password" v-model="loginForm.password" auto-complete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" class="loginBtn" @click="login">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      loginForm: {
        username: "admin",
        password: "123"
      },
      responseResult: []
    };
  },
  methods: {
    login() {
      this.$axios
        .post("/login", {
          username: this.loginForm.username,
          password: this.loginForm.password
        })
        .then(resolve => {
          if (resolve.data.code === 200) {
            this.$store.commit("login", this.loginForm);
            let path = this.$route.query.redirect;
            this.$router.push({
              path: path === "/" || path === undefined ? "/index" : path
            });
          }
        })
        .catch(reject => {
          console.log(reject);
        });
    }
  }
};
</script>

<style scoped lang="stylus">
@import '~stylus/variable';

.login {
  position: fixed;
  height: 100%;
  width: 100%;
  background: url('~assets/bimg.jpg');
  background-position: center;
  background-size: cover;
}

.login-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  border-radius: 15px;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
  opacity: 0.8;
}

.login_title {
  margin-bottom: 40px;
  text-align: center;
  color: #505458;
}

.loginBtn {
  width: 100%;
  background: #505458;
  border: none;
}

@media screen and (max-width: 786px) {
  .login-container {
    transform: translate(-50%, -50%) scale(0.5);
  }
}
</style>