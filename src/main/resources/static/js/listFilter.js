document.getElementById('searchInput').addEventListener('keyup', function() {
  let searchValue = this.value.toLowerCase();
  let tableRows = document.getElementById('table').getElementsByTagName('tr');
  
  for (let i = 1; i < tableRows.length; i++) {
    let rowText = tableRows[i].textContent.toLowerCase();
    if (rowText.indexOf(searchValue) > -1) {
      tableRows[i].style.display = '';
    } else {
      tableRows[i].style.display = 'none';
    }
  }
});


let rows = document.querySelectorAll("tr");

rows.forEach((row) => {
  let child = document.createElement('td');
  z.textContent = `(${child.rowIndex})`;
  row.prepend(z);
});