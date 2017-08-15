module.exports = function(config) {
    config.set({
        files: [
          'app/scripts/*.js',
          'test/spec/*.js'
        ],
        frameworks: ['jasmine'],
        browsers: ['Chrome'],
        autoWatch: true
    });
};