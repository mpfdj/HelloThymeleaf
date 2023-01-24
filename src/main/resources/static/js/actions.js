function sortByTitle(order) {
  if (order == "ascending") {
    location.href = "/list-the-marvel-universe?action=sort-by-title-asc";
  } else {
    location.href = "/list-the-marvel-universe?action=sort-by-title-desc";
  }
}