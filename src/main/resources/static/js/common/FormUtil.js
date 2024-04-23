/**
 * フォームを扱うためのクラス
 */
class FormUtil {

  /**
   * フォームの中身をJSON形式の文字列に変換する
   * 
   * @param {Object} $form フォームのjQueryオブジェクト
   * 
   * @returns JSON形式の文字列
   */
  static form2Json($form) {

    var data = FormUtil.form2Object($form);
    return JSON.stringify(data);
  }

  /**
   * フォームの中身をオブジェクトに変換する
   * 
   * @param {Object} $form フォームのjQueryオブジェクト
   * 
   * @returns オブジェクト
   */
  static form2Object($form) {

    const data = $form.serializeArray();

    let obj = {};
    for (let idx = 0; idx < data.length; idx++) {
      obj[data[idx].name] = data[idx].value
    }

    return obj;
  }
}