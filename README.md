## Note

Once updating daily pictures, just update the const `beginDay` and `lastDay` in `site/script.js`.

```javascript
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
```
