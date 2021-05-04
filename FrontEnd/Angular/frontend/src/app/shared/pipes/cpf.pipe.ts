import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'cpf'
})
export class CpfPipe implements PipeTransform {
  
  // 03030433  -> 04022-222
  transform(value: string, ...args: string[]): string {
    
    //console.log(value.toString());

    let cpfStr : string = value.toString();

    if (cpfStr.length < 8){
      cpfStr = cpfStr.padStart(8, '0')
    }

    //console.log(cpfStr);

    let cpf = cpfStr.substring(0, 3) + '.' + cpfStr.substring(3, 6) + '.' + cpfStr.substring(6, 9) + '-' + cpfStr.substring(9, 11);

    return cpf;
  }

}
