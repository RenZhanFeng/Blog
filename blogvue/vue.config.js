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
      }),
      new webpack.LoaderOptionsPlugin({
        //设置代理
        proxy: {
          '/api': {
            target: 'http://localhost:8443',
            changeOrigin: true,
            pathRewrite: {
              '^/api': ''
            }
          }
        }
      })
    ],
    //配置路径别名
    resolve: {
      alias: {
        'components': '@/components',
        'stylus': '@/common/stylus',
        'font': '@/common/font',
        'assets': '@/assets',
      }
    },
  },
};
