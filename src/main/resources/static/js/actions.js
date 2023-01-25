function sortByTitle(order) {
  if (order == "ascending") {
    location.href = "/list-the-marvel-universe?action=sort-by-title-asc";
  } else {
    location.href = "/list-the-marvel-universe?action=sort-by-title-desc";
  }
}

function sortByPopularity(order) {
  if (order == "ascending") {
    location.href = "/list-the-marvel-universe?action=sort-by-popularity-asc";
  } else {
    location.href = "/list-the-marvel-universe?action=sort-by-popularity-desc";
  }
}

function sortByReleaseDate(order) {
  if (order == "ascending") {
    location.href = "/list-the-marvel-universe?action=sort-by-release-date-asc";
  } else {
    location.href = "/list-the-marvel-universe?action=sort-by-release-date-desc";
  }
}

function sortByVoteAverage(order) {
  if (order == "ascending") {
    location.href = "/list-the-marvel-universe?action=sort-by-vote-average-asc";
  } else {
    location.href = "/list-the-marvel-universe?action=sort-by-vote-average-desc";
  }
}

function sortByVoteCount(order) {
  if (order == "ascending") {
    location.href = "/list-the-marvel-universe?action=sort-by-vote-count-asc";
  } else {
    location.href = "/list-the-marvel-universe?action=sort-by-vote-count-desc";
  }
}
