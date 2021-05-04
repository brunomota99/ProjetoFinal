import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'telephone'
})
export class TelephonePipe implements PipeTransform {
  
  // 03030433  -> 04022-222
  transform(value: string, ...args: string[]): string {
    
    //console.log(value.toString());

    let telephoneStr : string = value.toString();

    if (telephoneStr.length < 8){
      telephoneStr = telephoneStr.padStart(8, '0')
    }

    //console.log(telephoneStr);

    let telephone = '( ' + telephoneStr.substring(0, 2) + ')' + telephoneStr.substring(2, 7) + '.' + telephoneStr.substring(7, 11) 
    return telephone;
  }

}
