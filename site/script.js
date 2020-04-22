/**
 * Date range
 *
 * @let   {Number} overFlow  - DO NOT touch this...
 * @const {Number} beginDay  - the start day of our pics
 * @const {Number} endDay    - the last day of our pics
 * @const {Number} beginDate - the begin date to reset when date overflow
 *
 * @example:
 *
 * So, if you have pics from `day-1` till `day-8`:
 *
 * + set the `beginDay` to 1
 * + set the `lastDay`  to 8
 */
let overFlow = false;
const beginDay = 1;
const lastDay = 2;
const beginDate = $(".A").find("p").html();

/**
 * Move to next date safly
 *
 * @param {Number} monthLimit - how many days the month should have
 * @param {Number} year       - the year of the date
 * @param {Number} month      - the month of the date
 * @param {Number} date       - the date of the date
 */
function moveDate(monthLimit, year, month, date) {
  // check if overFlow
  if (overFlow) {
    return beginDate;
  }

  // leep year
  if (monthLimit === 28 && (year % 4) === 0) {
    monthLimit += 1;
  }

  // adapt date
  if (date === monthLimit) {
    month += 1;
    date = 1;

    if (month === 13) {
      month = 1;
      year += 1;
    }
  } else {
    date += 1;
  }

  // ensure double digits
  if (month.toString().length === 1) {
    month = "0" + month;
  }

  if (date.toString().length === 1) {
    date = "0" + date;
  }

  // return new date
  return `${year.toString().slice(2)}/${month}/${date}`;
}

/**
 * Get the next in date
 *
 * @param {String} fmt - fmt date, like `20/04/17`;
 */
function formatNextDay(fmt) {
  const fullDate = new Date("20" + fmt);
  let year = fullDate.getFullYear();
  let month = fullDate.getMonth() + 1;
  let date = fullDate.getDate();
  let ifNextMonth = false;

  if (month in [1, 3, 5, 7, 8, 11, 12]) {
    return moveDate(31, year, month, date);
  } else if (month in [4, 6, 9, 10]) {
    return moveDate(30, year, month, date);
  } else if (month === 2) {
    return moveDate(28, year, month, date);
  } else {
    return fmt;
  }
}

// Operate the DOM
$(document).ready(function(){
  $(".contianer").hover(
    function() {
      $(this).find("p").css("display", "block");
    }, function() {
      $(this).find("p").css("display", "none");
    });

  // Init picture idents
  const pics = [
    "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
  ];

  // Loop pics
  for (const pic in pics) {
    const ptr = "." + pics[pic];
    $(ptr).click(() => {
      const currentDay = Number($(ptr).css("background-image").match(/day-(\d)/)[1]);
      if (currentDay + 1 > lastDay) {
        overFlow = true;
      }

      const nextDay = overFlow? beginDay : currentDay + 1;

      // update the background image
      $(ptr).css(
        "background-image",
        $(ptr).css("background-image").replace(currentDay, nextDay)
      );

      // update the date
      $(ptr).find("p").html(formatNextDay($(ptr).find("p").html()));

      // clear overFlow
      if (overFlow) {
        overFlow = false;
      }
    });
  }
});

