import Vue from "vue";
import VueRouter from "vue-router";
import Login from 'components/Login/Login';
import Appindex from 'components/Home/Appindex'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: "Login",
    component: Login
  },
  {
    path: '/index',
    name: "Appindex",
    component: Appindex,
    meta: {
      requireAuth: true
    }
  }

];

const router = new VueRouter({
  routes,
  mode: 'history'
});

export default router;
