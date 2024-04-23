
const handlers = {

  update: () => {

    MessageUtil.clearErrorMessage();

    var postData = FormUtil.form2Json($('#form'));

    AjaxUtil.post({
      url: '/User/UserList/edit',
      data: postData,
    }).done((response) => {
      if (response.hasError) {
        MessageUtil.showErrorMessage(response.errors);
        return;
      }
      window.alert('更新完了しました');
      window.location.href = '/User/UserList';
      
    }).fail((response) => {
      console.log(response);
    });
  }
};

function scriptInit() {

  $('#updateButton').on('click', handlers.update);
}

scriptInit();

function deleteUser() {
    $('#{deleteButton').on('click', function() {
        
        if(window.alert('削除してよろしいでしょうか？')) {
            AjaxUtil.post({
                url: '/User/UserList/edit',
                data: {
                    employeeNo: $("#employeeNo").val()
                }
            }).done((response) => {
        if (response.hasError) {
           MessageUtil.showErrorMessage(response.errors);
           return;
        }
        window.alert('削除完了しました');
        window.location.href = '/User/UserList';
        }).fail(function() {
            alert('エラー');
            });
        }
    })
}
