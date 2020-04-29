const webpack = require("webpack");

module.exports = {
  publicPath: '/',
  configureWebpack: {
    plugins: [
      new webpack.LoaderOptionsPlugin({
        //设置代理
        proxy: {
          '/api': {
            target: 'http://clownz.xyz:8443',
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
        'common': '@/components/common',
        'stylus': '@/common/stylus',
        'font': '@/common/font',
        'assets': '@/assets',
      }
    },
  },
};

