
const handlers = {

    register: () => {

    MessageUtil.clearErrorMessage();

    var postData = FormUtil.form2Json($('#form'));

    AjaxUtil.post({
      url: '/Device/DeviceList/register',
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
      url: '/Device/DeviceList/edit',
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
    
    if(window.alert('削除してよろしいでしょうか？')) {
        var deviceNo = $(this).data("deviceNo");
        
        AjaxUtil.post({
            url: '/Device/DeviceList/edit',
            type: 'POST',
            datatype: 'json',
            data: {
                deviceNo: deviceNo
            }
        }).done((response) => {
            if (response.hasError) {
               MessageUtil.showErrorMessage(response.errors);
               return;
            }
        window.alert('削除完了しました');
        window.location.href = '/User/UserList';
        
        }).fail((response) => {
          console.log(response);
        });
    }
  }
};

function scriptInit() {

  $('#registerButton').on('click', handlers.register);
  $('#updateButton').on('click', handlers.update);
  $('#deleteButton').on('click', handlers.deleteDevice);
}

scriptInit();