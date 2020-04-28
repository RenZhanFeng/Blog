import Vue from "vue";
import VueRouter from "vue-router";
import Login from 'Mcomponents/Login/Login';
import Index from 'Fcomponents/Index/Index'
import Front from 'Fcomponents/Front'
import LibraryIndex from 'Fcomponents/Library/LibraryIndex'
import Manager from 'Mcomponents/Manager'
import ManagerIndex from 'Mcomponents/Index/managerIndex'
import blogEditor from 'Mcomponents/Index/content/blogEditor'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/index'
  },
  //前台路由
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
      },
      {
        path: '/library',
        name: 'Library',
        component: LibraryIndex,
      }
    ]
  },
  //后台路由
  {
    path: '/manager',
    name: 'Manager',
    component: Manager,
    //Front页面不需要被访问
    redirect: 'manager/login',
    children: [
      {
        path: 'login',
        name: "Login",
        component: Login
      },
      {
        path: 'index',
        name: 'ManagerIndex',
        component: ManagerIndex,
        meta: {
          requireAuth: true
        },
        children: [
          {
            path: 'blogEditor',
            name: 'blogEditor',
            component: blogEditor,
          }
        ]
      }
    ]
  }

];

const router = new VueRouter({
  routes,
  mode: 'history'
});

export default router;
