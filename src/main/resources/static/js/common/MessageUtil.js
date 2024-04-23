/**
 * メッセージ表示用ユーティリティ
 */
class MessageUtil {

  /**
   * エラーメッセージ表示領域のセレクタ
   */
  static ERROR_MESSAGE_AREA_CLASS = 'error-message-area'

  /**
   * エラーの発生したフィールドのクラス
   */
  static ERROR_FIELD_CLASS = 'error-field';

  /**
   * エラーメッセージを表示する
   * 
   * @param {Array} errors エラーメッセージ一覧
   */
  static showErrorMessage(errors) {

    MessageUtil.clearErrorMessage();

    errors.forEach(item => {

      const $message = $('<span>');
      $message.addClass(MessageUtil.ERROR_MESSAGE_AREA_CLASS);
      $message.text(item.defaultMessage);

      const $field = $(`[name="${item.field}"]`);
      $field.addClass(MessageUtil.ERROR_FIELD_CLASS);
      $field.after($message);
    });
  }

  /**
   * エラーメッセージをクリアする
   */
  static clearErrorMessage() {

    $(`.${MessageUtil.ERROR_MESSAGE_AREA_CLASS}`).remove();
    $(`.${MessageUtil.ERROR_FIELD_CLASS}`).removeClass(MessageUtil.ERROR_FIELD_CLASS);
  }
}