const path = require('path')

module.exports = {
	publicPath: process.env.NODE_ENV === 'production' ? './paytype/dist' : './',
	assetsDir: 'assets',
	outputDir: 'dist',
	indexPath: 'main.html',
	runtimeCompiler: true,
	 productionSourceMap: false,
}