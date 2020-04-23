import Vue from "vue";
import VueRouter from "vue-router";
import Login from 'components/Login/Login';
import Appindex from 'components/Home/Appindex'
import Home from 'components/Home'
import LibraryIndex from 'components/Library/LibraryIndex'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/library'
  },
  {
    path: '/login',
    name: "Login",
    component: Login
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
    //home页面不需要被访问
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: "Appindex",
        component: Appindex,
        meta: {
          requireAuth: true
        }
      },
      {
        path: '/library',
        name: 'Library',
        component: LibraryIndex,
        meta: {
          requireAuth: true
        }
      }
    ]
  }

];

const router = new VueRouter({
  routes,
  mode: 'history'
});

export default router;
