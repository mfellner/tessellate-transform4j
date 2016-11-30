const path = require('path')

module.exports = {
  entry: ['babel-polyfill', './src/main/javascript/index.js'],
  target: 'web',
  output: {
    path: path.resolve(__dirname, 'src/main/resources'),
    filename: 'tessellate.js',
    library: 'Tessellate',
    libraryTarget: 'var'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        loader: 'babel-loader',
        options: {
          presets: [['latest', {modules: false}]]
        }
      }
    ]
  }
}
