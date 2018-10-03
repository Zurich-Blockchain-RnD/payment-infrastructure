import { NgModule } from '@angular/core';

import { PaybackSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [PaybackSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [PaybackSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class PaybackSharedCommonModule {}
