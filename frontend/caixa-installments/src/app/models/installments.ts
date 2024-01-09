export class Installment {
    id?: string;
    nroContrato?: string;
    dueDate?: Date;
    paid?: boolean;
    amount?: number;
    interest?: number;
    insurance?: number;
    fees?: number;
    outstandingBalance?: number;
    monetaryCorrection?: number;
    amortization?: number;
    isContribution?: boolean;

    constructor(data: any) {
        this.convertAndAssign(data);
    }

    private convertAndAssign(data: any): void {
        this.id = data.id,
        this.nroContrato = data.nroContrato;
        this.dueDate = new Date(data.dueDate);
        this.paid = data.paid === 'true';  
        this.amount = parseFloat(data.amount);
        this.interest = parseFloat(data.interest);
        this.insurance = parseFloat(data.insurance);
        this.fees = parseFloat(data.fees);
        this.outstandingBalance = parseFloat(data.outstandingBalance);
        this.monetaryCorrection = parseFloat(data.monetaryCorrection);
        this.amortization = parseFloat(data.amortization);
        this.isContribution = data.isContribution === 'true'; 
    }
}
