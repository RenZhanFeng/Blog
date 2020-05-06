import Vue from "vue";
import VueRouter from "vue-router";
import Index from 'Fcomponents/Index/Index'
import Front from 'Fcomponents/Front'
import LibraryIndex from 'Fcomponents/Library/LibraryIndex'
import BlogDetails from 'Fcomponents/Index/common/blogDetails'
import Login from 'Mcomponents/Login/Login';
import Manager from 'Mcomponents/Manager'
import ManagerIndex from 'Mcomponents/Index/managerIndex'
import BlogEditor from 'Mcomponents/Index/blog/blogEditor'
import BlogManagement from 'Mcomponents/Index/blog/blogManagement'
import Category from 'Mcomponents/Index/category/category'



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
        children: [
          {
            path: 'blogDetails/:id',
            name: "blogDetails",
            component: BlogDetails
          }
        ]
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
    //manager页面不需要被访问
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
        redirect: 'index/blogManagement',
        meta: {
          requireAuth: true
        },
        children: [
          {
            path: 'blogManagement',
            name: 'blogManagement',
            component: BlogManagement,
            meta: {
              requireAuth: true
            },
          },
          {
            path: 'blogEditor',
            name: 'blogEditor',
            component: BlogEditor,
            meta: {
              requireAuth: true
            },
          },
          {
            path: 'category',
            name: 'category',
            component: Category,
            meta: {
              requireAuth: true
            },
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
