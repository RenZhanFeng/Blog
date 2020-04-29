import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user: {//登录
      username: window.localStorage.getItem('user') == null ? '' : JSON.parse(window.localStorage.getItem('user')).username
    },
    categories: [],//图书分类
    postsTotal: null,//文章数量
  },
  mutations: {
    login(state, user) {
      state.user = user
      window.localStorage.setItem('user', JSON.stringify(user))
    },
    getCategories(state, data) {
      state.categories = data
    },
    getpostsTotal(state,postsTotal){
      state.postsTotal = postsTotal
    }
  },
  actions: {},
  modules: {}
});
