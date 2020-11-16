export interface ClubMember {
  clubMemberId: number;
  clubMemberName: string;
  clubMemberAdress: string;
  clubMemberBirthday: Date;
  entranceDate: Date;
  terminationDate: Date;
  exitDate: Date;
  membership_type: String;
  annualFee: number;
  annualPaymentList: any;
  iban: string;
}
