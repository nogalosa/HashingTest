## HashingTest

An experimental hashing algorithm by me.

### Analizė
| Input | Hash | Time |
| --- | --- | --- |
| 1 | `t48349b85n9db85n9db85n9db85n9db85n9db85n9db85n9db85n9db85n9db85n` | 260 μs |
| 2 | `tkfo608atya6bqg3gjvuknwa3phn3d3gjvuknwa3phn3d3gjvuknwa3phn3d3gjv` | 269 μs |
| loremipsum1 (10009 simb.) | `5ccdmzq5re46d62594mndycuyrtz2594mndycuyrtz2594mndycuyrtz2594mndy` | 5446 μs |
| loremipsum2 (10017 simb.) | `5ccyb8pq4bvyeeq4bvyeeq4bvyeeq4bvyeeq4bvyeeq4bvyeeq4bvyeeq4bvyeeq` | 3003 μs | 
| loremipsum2 (10017 simb.) su pakeistu vienu simboliu | `n259bcmrfd3o4e05re3c0megk3m74hygn4rbycun5gmq4bvdjm5re3c0megk3m74` | 15987 μs |
| konstitucija | `c8nm4qrc8g46c8nm4qrc8g46c8nm4qrc8g46c8nm4qrc8g46c8nm4qrc8g46c8nm...` | 123513 μs (124 ms) |
| a1000000 | Iš 1 000 000 porų nei vienas hashas nesutapo | 5917 ms |