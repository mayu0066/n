
const handlers = {

  update: () => {

    MessageUtil.clearErrorMessage();

    var postData = FormUtil.form2Json($('#form'));

    AjaxUtil.post({
      url: '/Device/LeaseDetail/edit',
      data: postData,
    }).done((response) => {
      if (response.hasError) {
        MessageUtil.showErrorMessage(response.errors);
        return;
      }
      window.alert('更新完了しました');
      window.location.href = '/Device/LeaseList';
      
    }).fail((response) => {
      console.log(response);
    });
  }
};

function scriptInit() {

  $('#leaseButton').on('click', handlers.update);
}

scriptInit();

