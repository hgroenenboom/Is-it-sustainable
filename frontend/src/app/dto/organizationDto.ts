
export class OrganizationDto {
  id: number;
  name: string;
  website: string;
  partnerIds: number[];

  constructor(id: number, name: string, website: string, partnerIds: number[]) {
    this.id = id;
    this.name = name;
    this.website = website;
    this.partnerIds = partnerIds;
  }
}
