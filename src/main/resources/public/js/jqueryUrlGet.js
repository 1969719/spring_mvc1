// jQuery url get parameters function [��ȡURL��GET����ֵ]
// <code>
//     var GET = $.urlGet(); //��ȡURL��Get����
//     var id = GET['id']; //ȡ��id��ֵ
// </code>
//  url get parameters
//  public
//  return array() 
(function($) {
$.extend({       
urlGet:function()
{
    var aQuery = window.location.href.split("?");  //ȡ��Get����
    var aGET = new Array();
    if(aQuery.length > 1)
    {
        var aBuf = aQuery[1].split("&");
        for(var i=0, iLoop = aBuf.length; i<iLoop; i++)
        {
            var aTmp = aBuf[i].split("=");  //����key��Value
            aGET[aTmp[0]] = aTmp[1];
        }
     }
     return aGET;
 }
})
})(jQuery);