const webpack = require("webpack");

module.exports = {
  publicPath: '/',
  configureWebpack: {
    plugins: [
      new webpack.LoaderOptionsPlugin({
        //设置代理
        proxy: {
          '/api': {
            target: 'https://clownz.xyz/api',
            // target: 'http://localhost:8443/api',
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
        'Fcomponents': '@/components/Front',
        'Mcomponents': '@/components/Manager',
        'common': '@/common',
        'stylus': '@/common/stylus',
        'font': '@/common/font',
        'assets': '@/assets',
      }
    },
  },
};

