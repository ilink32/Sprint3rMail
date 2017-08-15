describe("validate campaign name", function() {

  it("Case Input Empty", function(){
    window.$ = function(v) {
      return {
        val: function() {
          return "";
        }
      }
    }
    var expected = "Please input campaign Name";
    var result = validateCampaignName();
    expect(result).toEqual(expected);
  });

  it("Case Input not Empty", function(){
    window.$ = function(v) {
      return {
        val: function() {
          return "New Campaign Name";
        }
      }
    }
    var expected = "";
    var result = validateCampaignName();
    expect(result).toEqual(expected);
  });

})