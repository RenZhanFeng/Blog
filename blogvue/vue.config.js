const webpack = require("webpack");

module.exports = {
 configureWebpack: {
     //引进jQuery
   plugins: [
     new webpack.ProvidePlugin({
       $: "jquery",
       jQuery: "jquery",
       "window.jQuery": "jquery",
       Popper: ["popper.js", "default"]
     })
   ],
   //配置路径别名
   resolve:{
    alias:{
      'components':'@/components',
      'stylus':'@/common/stylus',
      'font':'@/common/font',
    }
   }
 }
};
