module.exports = function(config) {
    config.set({
        files: [
          'bower_components/jquery/dist/jquery.js',
          'app/scripts/create_campaign.js',
          'test/spec/*.js'
        ],
        frameworks: ['jasmine'],
        browsers: ['Chrome'],
        autoWatch: true
    });
};