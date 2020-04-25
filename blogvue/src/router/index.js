import Vue from "vue";
import VueRouter from "vue-router";
import Login from 'Mcomponents/Login/Login';
import Index from 'Fcomponents/Index/Index'
import Front from 'Fcomponents/Front'
import LibraryIndex from 'Fcomponents/Library/LibraryIndex'

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
    path: '/front',
    name: 'Front',
    component: Front,
    //Front页面不需要被访问
    redirect: '/index',
    children: [
      {
        path: '/index',
        name: "Index",
        component: Index,
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
