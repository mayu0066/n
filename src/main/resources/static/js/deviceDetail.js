
const handlers = {

    register: () => {

    MessageUtil.clearErrorMessage();
    
    var postData = FormUtil.form2Json($('#form'));

    AjaxUtil.post({
      url: '/Device/DeviceDetail/register',
      data: postData,
    }).done((response) => {
      if (response.hasError) {
        MessageUtil.showErrorMessage(response.errors);
        return;
      }
      window.alert('登録完了しました');
      window.location.href = '/Device/DeviceList';
      
    }).fail((response) => {
      console.log(response);
    });
  },
  
  
  update: () => {

    MessageUtil.clearErrorMessage();

    var postData = FormUtil.form2Json($('#form'));

    AjaxUtil.post({
      url: '/Device/DeviceDetail/edit',
      data: postData,
    }).done((response) => {
      if (response.hasError) {
        MessageUtil.showErrorMessage(response.errors);
        return;
      }
      window.alert('更新完了しました');
      window.location.href = '/Device/DeviceList';
      
    }).fail((response) => {
      console.log(response);
    });
  },
  
  deleteDevice: () => {
    
    MessageUtil.clearErrorMessage();
    
    var postData = FormUtil.form2Json($('#form'));
    
    AjaxUtil.post({
        url: '/Device/DeviceDetail/delete',
        data: postData,
    }).done((response) => {
        if (response.hasError) {
           MessageUtil.showErrorMessage(response.errors);
           return;
        }
    window.alert('削除完了しました');
    window.location.href = '/Device/DeviceList';
    
    }).fail((response) => {
      console.log(response);
    });
    }
};

function scriptInit() {

  $('#registerButton').on('click', handlers.register);
  $('#updateButton').on('click', handlers.update);
  $('#deleteButton').on('click', handlers.deleteDevice);
}

scriptInit();