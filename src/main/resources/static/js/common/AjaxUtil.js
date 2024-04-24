/**
 * Ajax通信用ユーティリティ
 */
class AjaxUtil {

  /**
   * デフォルトのオプション
   */
  static DEFAULT_OPTIONS = {
    contentType: 'application/json',
    dataType: 'json',
  };

  /**
   * POSTを行う
   * 
   * @param {Object} options オプション ※urlやdata等を指定
   * 
   * @returns Ajaxオブジェクト
   */
  static post(options) {

    const opt = $.extend({}, AjaxUtil.DEFAULT_OPTIONS, options, {
      type: 'POST'
    });

    return $.ajax(opt);
  }

}